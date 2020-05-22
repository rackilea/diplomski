ModelAndViewContainer mavContainer = (ModelAndViewContainer) request
        .getAttribute("ModelAndViewContainer.clinapps");

if (mavContainer != null)
    {
        modelAndView.getModelMap().mergeAttributes(mavContainer.getModel());
    }