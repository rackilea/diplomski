class WinIconChanger {
    static public void main(String[] args) {
        String filePath = "UNKNOWN";
        String state = "UNKNOWN";
        if (args.length == 2) {
            filePath = args[1];

            switch (args[0]) {
            case "PLANNED_WORK":
            case "HALF-DONE_WORK":
            case "DONE_WORK":
                state = args[0];
                break;
            default:
                break;
            }
        }

        if ("UNKNOWN".equals(state)) {
            javax.swing.JOptionPane.showMessageDialog(
                    null, 
                    "Unknown file or state !", 
                    "WinIconChanger Error", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        } else {
            /* 
             * Change the icon of the file specified in args[1]
             * according to the state specified in args[0]
             */
            String msg = String.format(
                    "Let's assume I just changed the icon of '%s' to %s !",
                    filePath, state);
            javax.swing.JOptionPane.showMessageDialog(
                    null, 
                    msg,
                    "WinIconChanger Info",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }
}