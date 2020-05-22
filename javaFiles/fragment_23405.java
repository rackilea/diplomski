static void lastQuestionDialog(final Context context, List<Question> list)
 {
  List<Integer> wrongList = UIResponse.checkAnswer(list);
   if (wrongList.size() == 0)
   {
new AlertDialog.Builder(context).setTitle("Info")
      .setMessage("You are awesome and all answers are correct!")
       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which)
           {
             ((Activity)context).finish();
           }
          }).setNegativeButton("Cancel", null).show();
    }
 }