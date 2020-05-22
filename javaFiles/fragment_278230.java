public static void main(String[] args) throws Exception {

        String fileName = "C:\\rsc\\intdat.dat";

        int sum = 0;

        DataInputStream instr=null;
        try {
            instr = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)));

            while (instr.available()!=0) {
                sum += Integer.parseInt(instr.readLine());
                System.out.println("The sum is: " + sum);
            }
        } catch (EOFException e) {
            System.out.println("EOF reached for: " + fileName);
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Problem reading " + fileName);
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        finally{
            if(instr!=null)
            instr.close();
        }

    }