StringBuilder DETA5 = new StringBuilder();

for (int i = 1; i < TKG.length; i++)
{
  if (TKG[i].equals("~"))
  {
    for (int x = 0; x < i; x++)
    {
      DETA5.append(TKG[x]);
    }
  }
}

int D = D + DETA5.length();

String[] TKC = new String[6];

for (int i = 0; i < 6; i++)
{
  TKC[i] = GUY.substring(i+D1, i + 1 + D1);
}

StringBuilder DETA_1_1 = new StringBuilder();

for (int i = 1; i < TKC.length; i++)
{
  if (TKC[i].equals("~"))
  {
    for (int x = 0; x < i; x++)
    {
      DETA_1_1.append(TKC[x]);
    }
  }
}