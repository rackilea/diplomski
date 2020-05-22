public static void main(String[] args) {
    for (int t = 100_000;  t <= 100_000_000; t *= 10) {
        int[] nums = new int[t];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt();
        }
        long start = System.currentTimeMillis();
        swaps = 0;
        randomizedQuickSort(nums, 0, nums.length - 1);
        long time = System.currentTimeMillis() - start;
        for (int i=0;i<nums.length-1;i++)
            if (nums[0] > nums[1])
                throw new AssertionError();
        System.out.printf("%d: Took %f seconds, and %d swaps%n", t, time / 1e3, swaps);
    }
}

static void randomizedQuickSort(int[] a, int l, int r) {
    if (l >= r) {
        return;
    }

    long m = Partition3(a, l, r);
    int m0 = (int) (m >> 32);
    int m1 = (int) m;
    randomizedQuickSort(a, l, m0 - 1);
    randomizedQuickSort(a, m1 + 1, r);
}

static final Random random = new Random();
static long swaps = 0;

private static long Partition3(int[] nums, int l, int r) {
    int k = random.nextInt(r - l + 1) + l;
    int mid = nums[k];
    int m1 = l;
    int i = l;
    int m2 = r;


    while (m1 <= m2) {
        if (nums[m1] < mid) {
            swap(nums, i, m1);
            i++;
            m1++;
        } else if (nums[m1] > mid) {
            swap(nums, m1, m2);
            m2--;
        } else {
            m1++;
        }
    }

    return ((long) i << 32) | m2;
}

private static void swap(int[] nums, int i, int j) {
    int t = nums[i];
    nums[i] = nums[j];
    nums[j] = t;
    swaps++;
}