static void Main(string[] args)
        {
            int[] array1 = {-3, 8, 3, 1, 1, 3}; // { -3, 8, 3, 1, 1, 3, 6, 1, 19 };
            int indexPosition = GetIndex(array1);
            if (indexPosition != -1)
            {
                Console.WriteLine(indexPosition);
            }
        }

        static int GetIndex(int[] param)
        {
            if (param.Length < 0) return -1;
            int leftSum = 0, rightSum = 0; int rightIndex = param.Length - 1;
            for (int i = 0; i < param.Length; i++)
            {
                if (i < rightIndex)
                {
                    if (leftSum > rightSum)
                    {
                        rightSum += param[rightIndex];
                        rightIndex -= 1;
                    }
                    else
                    {
                        if (i < rightIndex)
                        {
                            leftSum += param[i];
                        }
                    }
                }
                else
                {
                    rightSum += param[rightIndex]; // if you are looking for only index position you can comment this line,
                    //variable rightSum and leftSum will give you the sum of left and right side of the array
                    rightIndex -= 1;
                    break;
                }
            }

            return rightIndex;
        }