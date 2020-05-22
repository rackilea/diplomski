class Numbers {

        int number;

        public boolean isTriangularNumber(int number) {
            int x = 1;
            int triangularNumber = 1;

            while (triangularNumber < number) {
                x++;
                triangularNumber = triangularNumber +x;

            }

            if (triangularNumber == number) {
                return true;
            } else {
                return false;
            }
        }