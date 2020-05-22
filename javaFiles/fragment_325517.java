@RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
    public ModelAndView addQuestion(Model model, @RequestParam(value="question", required = true)  String theQuestion , @RequestParam(value="questionId", required = true)  Integer questionId, @RequestParam(value="category", required = true)   String category, @RequestParam(value="correctAnswer", required = true)   String correctAnswer) throws SQLException{
        ViewController viewController = new ViewController();
        viewController.createQuestion(questionId, theQuestion, category, correctAnswer);

        return return new ModelAndView("qFour", "question", new Question());
    }