int arr[] = {10, 40, 60, -15, -25, 30, -10, -50};

List b = Arrays.asList(ArrayUtils.toObject(arr));

int mn = Collections.min(b);
int mx = Collections.max(b);

int perc_arr = new int[arr.length];
for(int i = 0; i < arr.length; i++)
     perc_arr[i] = (arr[i]-mn)/(mx-mn)*100;