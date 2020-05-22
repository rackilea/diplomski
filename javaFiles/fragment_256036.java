if (dateOfDelivery.equals(" ") || dateOfDelivery.equals("")) {
            String errorMsq = "Error create Order, enter return Date";
            log.error(errorMsq);
            new ErrorRedirect().sendRedirect(ErrorRedirect.ERROR_MAIN_MENU_URL + errorMsq, response);
            return "redirected...";
}