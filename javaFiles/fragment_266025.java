final Session session = sessionFactory.openSession();
String str =  " SELECT * FROM (SELECT lcl.line_nr line_nr, lcl.LINE_NR_SHRT_DESC_TXT LINE_NR_SHRT_DESC_TXT, mf.FSC_CD FSC_CD, mf.LCL_PRFL_CD LCL_PRFL_CD, NVL(mfi.SML_img_mrktg_fsc_path_txt, NVL (mfi.SML_IMG_MRKTG_CNCPT_PATH_TXT, '')) AS small, NVL (mfi.lrg_img_mrktg_fsc_path_txt, NVL(mfi.LRG_IMG_MRKTG_CNCPT_PATH_TXT, '')) AS large, NVL (mfi.XL_img_mrktg_fsc_path_txt, NVL (mfi.XL_IMG_MRKTG_CNCPT_PATH_TXT, '')) AS xl FROM lcl_line_nr_lang lcl, mrkt_fsc mf, mrkt_fsc_img mfi WHERE lcl.mrkt_id = mrkt_id AND lcl.lang_cd = lang_cd AND lcl.cmpgn_nr = cmpgn_nr AND lcl.cmpgn_yr_nr = cmpgn_yr_nr AND lcl.mrkt_id = mf.mrkt_id AND lcl.item_fsc_nr = mf.item_fsc_nr AND mf.mrkt_id = mfi.mrkt_id(+)AND mf.mrkt_fsc_id = mfi.mrkt_fsc_id(+)) a WHERE (a.large = '' OR a.large IS NULL OR a.xl = '' OR a.xl IS NULL OR a.small = '' OR a.small IS NULL)" ;
SQLQuery q = session.createSQLQuery(str);
List<Object[]> entities = q.list();
for (Object[] entity : entities) {
    for (Object entityCol : entity) {
        System.out.print(" " + entityCol);
    }
    System.out.println("");
}