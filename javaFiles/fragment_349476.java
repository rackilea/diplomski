AjaxLink openPopup = new AjaxLink("openPopup") 
{
    @Override
    public void onClick(AjaxRequestTarget target) 
    {
        tmpPassChange.show( target );
    }
};
add (openPopup);