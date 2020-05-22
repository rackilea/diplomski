public BigInteger prodBigBig(BigInteger a, BigInteger b, int base ){

            BigInteger result = BigInteger.ZERO;

            if(a.compareTo(result) == 0 || b.compareTo(result) == 0)
                return result;

            int m = a.toString().length();
            int n = b.toString().length();
            int carry;
            int temp;
            ArrayList<Integer>listA = new ArrayList<>();
            ArrayList<Integer>listB = new ArrayList<>();
            int[] listC = new int[m + n];

            for(int i = m - 1; i >= 0; i--){
                listA.add(Character.getNumericValue( a.toString().charAt(i)));
                listC[i] = 0;
            }

            for(int i = n - 1; i >= 0; i--) {
                listB.add(Character.getNumericValue(b.toString().charAt(i)));
            }

            for(int k=0; k < n; k++) {
                carry = 0;
                for(int i = 0; i < m ; i++){
                    temp = (listA.get(i) * listB.get(k)) + listC[i + k] + carry;
                    listC[i + k] = temp % base;
                    carry = temp / base;
                }
                listC[k + m] = carry;
            }

            for(int i= 0; i < m + n; i++){
                result = result.add(BigInteger.valueOf((long) (listC[i] * Math.pow(base, i))));
            }
            return result;

    }