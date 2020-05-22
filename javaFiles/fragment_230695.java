@Override
public Object getAsObject(FacesContext context, 
                          UIComponent component, String value) {
    if (value == null) {
        return null;
    }

    long idValue;
    try {
        idValue = Long.parseLong(value);
    }
    catch (NumberFormatException ex)
    {
        return null;
    }

    ServicePlayer servicePlayer = context.getApplication()
            .evaluateExpressionGet(context, "#{servicePlayer}",
                    ServicePlayer.class);
    Player player = servicePlayer.getPlayerByID(idValue);
    return player;

}