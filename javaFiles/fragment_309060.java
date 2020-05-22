if(getActivity() != null)
    Intent intenta = StatisticsActivity.newInstance(this, (Question)mStream.get(position));
// Also, this line should be giving you a compiler error
// because you created intenta inside if clause, so
// it's not visible here
startActivity(intenta);