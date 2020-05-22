import java.awt.*;
....
button.addActionListener(new ActionListener() {
            @override
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                printPDF("path/to/file/.pdf");
            }
        });