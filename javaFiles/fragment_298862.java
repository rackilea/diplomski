@Override
    public @ResponseBody List<CourseDetails> sectionList(@ModelAttribute("course_details_create") CourseDetails cd,
            @RequestParam("cdtype") Long cdtype, Model model) {

        Session session = getSession();
        String query = "WITH RECURSIVE  tree(parent, idElement) AS" + "(" +

                "SELECT  e.fk_course_det_id, e.course_det_id,e.course_name,e.course_desc,e.fk_book_id,e.fk_org_id"
                + " FROM course_details AS e" + " WHERE course_det_id =" + cdtype + " UNION ALL" +

                " SELECT d.fk_course_det_id, d.course_det_id,d.course_name,d.course_desc,d.fk_book_id,d.fk_org_id AS course_det_id"
                + " FROM tree" + "  INNER JOIN course_details AS d" + " ON tree.idElement = d.fk_course_det_id" + " )"
                + " SELECT *" + " FROM tree";

        SQLQuery qry = session.createSQLQuery(query);
        qry.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List<CourseDetails> results = qry.list();

        return results;

    }