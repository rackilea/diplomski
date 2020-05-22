String[] matches = new String[] {"adsf", "qwer"};

bool found = false;
for (String s : matches)
{
  if (input.contains(s))
  {
    execute();
    break;
  }
}