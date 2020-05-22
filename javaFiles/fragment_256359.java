lastvalue++;
                sum = sum + gs.getImagelevel();
                rollingnumber[lastvalue] += sum;
                for (int i = 0; i < lastvalue; i++)
                {
                    Log.i("hello", "i :: " + i + "array :: " + rollingnumber[i]
                            + "   lastvalue :: " + lastvalue);
                }