int[] a = new int[] {0};
int[] b = new int[] {0};

System.out.println(a.hashCode());
// 705927765 ; changes every time

System.out.println(b.hashCode());
// 366712642 ; changes every time

System.out.println(a.equals(b));
// false