if (action.equals("/lessonTimetable")) {
    if (request.getParameter("btnSelect") != null) {
        // This code will make sure lessons are retrieved from session data 
        this.selectedLesson = session.setAttribute("lessons")  == null ? 
             new LessonSelection(getID):(LessonSelection)session.getAttribute("lessons") );
        //... Do all other operation you are doing 
        this.selectedLesson.addLesson(lessons);
        session.setAttribute("lessons", this.selectedLesson.getAll());
        //System.out.println(selectedLesson.getItems());
        //check for duplicate lessons
        rd = this.getServletContext().getRequestDispatcher("/LessonSelectionView.jspx");

     }
 }