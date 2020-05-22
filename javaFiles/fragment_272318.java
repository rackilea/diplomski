public class CustomerContextHolder { 

    private static HttpSession getCurrentSession(){
             HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance()
                 .getExternalContext().getRequest();

             return request.getSession();
    }

    public static void setCustomerType(Integer customerType) {

       CustomerContextHolder.getCurrentSession().setAttribute("userType", customerType);

    }

    public static Integer getCustomerType() {

        return (Integer) CustomerContextHolder.getCurrentSession().getAttribute("userType");
    }

    public static void clearCustomerType() {
        contextHolder.remove(); // You may want to remove the attribute in session, dunno
    }
}