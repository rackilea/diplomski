Collections.sort(humanSortedList, new AlphaNumericObjectComparator<QuartzJobWrapper>()
            {
                @Override
                public int compare(QuartzJobWrapper t1, QuartzJobWrapper t2)
                {
                    return compareStrings(t1.getName(), t2.getName());
                }
            });