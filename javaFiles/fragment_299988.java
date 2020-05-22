int total = 200;

               System.out. printf("quarter\tdime\tnickle\tpenny\tto make %d\n", total);

                int combos = 0;

                for (int q = 0; q <= total / 25; q++)
                {
                    int total_less_q = total - q * 25;
                    for (int d = 0; d <= total_less_q / 10; d++)
                    {
                        int total_less_q_d = total_less_q - d * 10;
                        for (int n = 0; n <= total_less_q_d / 5; n++)
                        {
                            int p = total_less_q_d - n * 5;
                            System.out.printf("%d\t%d\t%d\t%d\n", q, d, n, p);
                            combos++;
                        }
                    }
                }

                System.out.printf("%d combinations\n", combos);