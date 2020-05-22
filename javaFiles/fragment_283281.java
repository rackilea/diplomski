public class HotelDetails extends BodyTagSupport {

    private static final long serialVersionUID = 1141701851233089895L;
    private Hotel hotel;
    private ArrayList<Hotel> hotelArray;
    Iterator<Hotel> it;

    public ArrayList<Hotel> getHotelArray() {
        return hotelArray;
    }

    public void setHotelArray(ArrayList<Hotel> hotelArray) {
        this.hotelArray = hotelArray;
        it = hotelArray.iterator();
    }

    @Override
    public int doStartTag() throws JspException {
        return EVAL_BODY_INCLUDE;
    }

    @Override
    public int doAfterBody() throws JspException {
        if (it.hasNext()) {
            hotel = it.next();

            pageContext.setAttribute("hotelName", hotel.getName());
            pageContext.setAttribute("hotelDesc", hotel.getDescription());

            return EVAL_BODY_AGAIN;
        } else {
            return SKIP_BODY;
        }

    }
}