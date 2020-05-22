private static String[] initDays( int number )
{
    String[] result = new String[ number];

    for ( int i = 0; i < result.length; i++ )
    {
        result[i] = "" + ( i+1);
    }

    return result;
}

private static final String[] days28 = initDays( 28);
private static final String[] days29 = initDays( 29);
private static final String[] days30 = initDays( 30);
private static final String[] days31 = initDays( 31);

private static final ComboBoxModel<String> model28 = new DefaultComboBoxModel<>(days28);
private static final ComboBoxModel<String> model29 = new DefaultComboBoxModel<>(days29);
private static final ComboBoxModel<String> model30 = new DefaultComboBoxModel<>(days30);
private static final ComboBoxModel<String> model31 = new DefaultComboBoxModel<>(days31);

private static final Set<Month> month30 = EnumSet.of(
         Month.FEBRUARY,
         Month.APRIL,
         Month.JUNE,
         Month.SEPTEMBER,
         Month.NOVEMBER
     );
private static final Set<Month> month31 = EnumSet.of(
         Month.JANUARY,
         Month.MARCH,
         Month.MAY,
         Month.JULY,
         Month.AUGUST,
         Month.OCTOBER,
         Month.DECEMBER
     );
private JComboBox<String> cbMonths = new JComboBox<>();
private JComboBox<String> cbDays = new JComboBox<>();

public void itemStateChanged(ItemEvent e)
{
    if(e.getSource() == cbMonths)//Check where combobox occured.
    {
        if(cbMonths.getSelectedItem().equals("February"))
        {
            Month selectedMonth = Month.valueOf( cbMonths.getItemAt( cbMonths.getSelectedIndex() ) );

            if ( month31.contains( selectedMonth ) )
            {
                cbDays.setModel( model31 );
            }
            else if ( month30.contains( selectedMonth ) )
            {
                cbDays.setModel( model30 );
            }
            else
            {
                if ( Year.isLeap( Instant.now().getLong( ChronoField.YEAR ) ) )
                {
                    cbDays.setModel( model29 );
                }
                else
                {
                    cbDays.setModel( model28 );
                }
            }
        }
    }
}