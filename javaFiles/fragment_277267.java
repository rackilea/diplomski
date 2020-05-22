class OverflowTest
{
        public static void main (String[] args)
        {
                System.out.println(isOverflow((short)32767, (short)32767, '+'));
                System.out.println(isOverflow((short)-32767, (short)-32767, '+'));
                System.out.println(isOverflow((short)32767, (short)-32767, '+'));       
        }

        private static boolean isOverflow(short a, short b, char op) {  
                short c = (op == '+') ? (short)(a+b) : (short)(a-b);
                if((a > 0 && b > 0 && c < 0) || (a < 0 && b < 0 && c > 0))
                        return true;
                return false;
        }
}