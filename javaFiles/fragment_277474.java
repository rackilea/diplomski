if (diallerPanelSum.compareTo(BigDecimal.ZERO) > 0)
{

    if (e.getSource() == buttonMakeCall)
    {
        diallerPanelSum = diallerPanelSum.subtract(BigDecimal.ONE);
    }

    if (e.getSource() == buttonSendText)
    {
        diallerPanelSum = diallerPanelSum.subtract(new BigDecimal("0.10"));
    }

    if (e.getSource() == buttonTopUp)
    {
        diallerPanelSum = diallerPanelSum.add(BigDecimal.TEN);
    }

}