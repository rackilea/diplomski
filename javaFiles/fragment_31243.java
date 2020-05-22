final TextView txtAbility = (TextView) v.findViewById(R.id.ability);

// Change the item color
// This one is based on the TextView's text value, since mine was a game score.
// You can change the int ability to match the item position.
final int ability = Integer.parseInt((String) txtAbility.getText());
if (ability > 40)
{
    txtAbility.setBackgroundResource(R.drawable.ability_yellow_btn);
}
else
    if (ability > 20)
    {
        txtAbility.setBackgroundResource(R.drawable.ability_green_btn);
    }
}