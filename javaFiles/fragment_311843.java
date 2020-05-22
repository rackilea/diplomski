public class AppointmentEmailContext extends AbstractEmailContext<AppointmentProcessModel>
{
   private String myAttribute;

    @Override
    public void init(final AppointmentProcessModel appointmentProcessModel, final EmailPageModel emailPageModel)
    {
        super.init(appointmentProcessModel, emailPageModel);
        myAttribute = appointmentProcessModel.getMyAttribute();
    }

    public String getMyAttribute() {
        return myAttribute;
    }

    //...
}