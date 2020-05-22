public class MedianOfTwoSortedArrays 
    {   
        //[1,2],{3,4}
        static int[] nums1 = new int[]{1, 3};
        static int[] nums2 = new int[]{2};


        public static void main(String args[])
        {
            int a[] = findMedianSortedArrays(nums1, nums2);

            for(int i=0;i<a.length;i++){
                System.out.println(a[i]);
            }
          }

            public static int[] findMedianSortedArrays(int[] nums1, int[] nums2) 
            {
                int[] sorted = new int[nums1.length + nums2.length];
                int i = 0, j = 0, k = 0;

                while (i < nums1.length && j < nums2.length)
                {
                    if (nums1[i] < nums2[j])
                    {
                        sorted[k] = nums1[i];
                        i++;
                    }
                    else
                    {
                        sorted[k] = nums2[j];
                        j++;
                    }
                    k++;
                }

                while (i < nums1.length)
                {
                    sorted[k] = nums1[i];
                    i++;
                    k++;
                }

                while (j < nums2.length)
                {
                    sorted[k] = nums2[j];
                    j++;
                    k++;
                }

                return sorted;
            }

    }