LinearLayout menuLayout= (LinearLayout) activity.getLayoutInflater().inflate(menuId, null);

int layoutCount = menuLayout.getChildCount();
for (int i = 0; i < layoutCount; i++)  
{
    View itemView = menuLayout.getChildAt(i);
    if (itemView instanceof LinearLayout)
    {
        LinearLayout itemLayout = (LinearLayout) itemView;
        int count = ((LinearLayout) itemView).getChildCount();
        for (int j = 0; j < count; j++)
        {
            View view = itemLayout.getChildAt(j);
            if (view instanceof ImageView)
                ((ImageView) view).setImageResource(R.drawable.newImage);
        }
    }
 }