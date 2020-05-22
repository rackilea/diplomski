public void onClick(View v) {

String tag = power.getTag().toString().trim();

if(tag.equals("off"))
{
    power.setImageResource(R.drawable.acondormant);
    power.setTag("on");
}
else if(tag.equals("on"))
{
    power.setImageResource(R.drawable.acoffdormant);
    power.setTag("off");
}


    }
};