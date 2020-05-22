String[] command = {
                    "/bin/sh",
                    "-c",
                    "ifconfig lo0 | grep -oP '[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}'"
            }; 
Process child = Runtime.getRuntime().exec(command);
// following here your remaining unchanged code