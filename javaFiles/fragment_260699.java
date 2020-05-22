import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Register extends JFrame implements ActionListener
{
    JTextField pro_pic_text;
    JLabel pro_pic_lbl;
    JButton browse_btn,upload_btn;
    public Register()
    {
        setLayout(new GridBagLayout());

        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.insets = new Insets(5,3,5,3);

        pro_pic_lbl = new JLabel("Profile Picture :");
        gbc1.gridx = 0;
        gbc1.gridy = 1;
        gbc1.ipadx = 0;
        gbc1.ipady = 0;
        gbc1.gridheight = 1;
        gbc1.gridwidth = 1;
        gbc1.fill = GridBagConstraints.HORIZONTAL;
        gbc1.anchor = GridBagConstraints.WEST;
        add(pro_pic_lbl,gbc1);

        pro_pic_text = new JTextField(30);
                pro_pic_text.setEditable(false);
        gbc1.gridx = 1;
        gbc1.gridy = 1;
        gbc1.ipadx = 0;
        gbc1.ipady = 0;
        gbc1.gridheight = 1;
        gbc1.gridwidth = 3;
        gbc1.fill = GridBagConstraints.HORIZONTAL;
        gbc1.anchor = GridBagConstraints.WEST;
        add(pro_pic_text,gbc1);

                browse_btn = new JButton("Browse...");
                browse_btn.addActionListener(this);
        gbc1.gridx = 4;
        gbc1.gridy = 1;
        gbc1.ipadx = 0;
        gbc1.ipady = 0;
        gbc1.gridheight = 1;
        gbc1.gridwidth = 1;
        gbc1.fill = GridBagConstraints.NONE;
        gbc1.anchor = GridBagConstraints.WEST;
        add(browse_btn,gbc1);

                upload_btn = new JButton("Upload");
                upload_btn.addActionListener(this);
        gbc1.gridx = 5;
        gbc1.gridy = 1;
        gbc1.ipadx = 0;
        gbc1.ipady = 0;
        gbc1.gridheight = 1;
        gbc1.gridwidth = 1;
        gbc1.fill = GridBagConstraints.NONE;
        gbc1.anchor = GridBagConstraints.WEST;
        add(upload_btn,gbc1);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
            if(ae.getSource() == browse_btn)
            {
                FileDialog fd = new FileDialog(new LibrarySystem(), "Choose Profile Picture",FileDialog.LOAD);
                fd.show();
                if(fd.getFile()==null&&pro_pic_text.getText().toString().trim().equals(""))
                {
                    JOptionPane.showMessageDialog(this,"Choose your Profile Picrure","Warning",JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    File ff1 = new File(fd.getFile());
                    String ffname = ff1.getName();
                    int aa = ffname.indexOf(".");
                    fftype = ffname.substring(aa+1);
                    if(fftype.equals("png") || fftype.equals("PNG") || fftype.equals("JPEG") || fftype.equals("jpeg") || fftype.equals("JPG") || fftype.equals("jpg"))
                    {
                        fileName = fd.getDirectory() + fd.getFile();
                        File ff2 = new File(fileName);
                        if(ff2.length()<=51300)
                        {
                            pro_pic_text.setText(fileName);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(this,"File size larger then 50kb not allowed","Warning",JOptionPane.WARNING_MESSAGE);
                            pro_pic_text.setText("");
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this,"Choose JPEG, JPG or PNG File","Warning",JOptionPane.WARNING_MESSAGE);
                        pro_pic_text.setText("");
                    }
                }
            }
            else if(ae.getSource() == upload_btn)
            {
                pro_pic = pro_pic_text.getText().toString().trim();
                if(pro_pic.equals(""))
                {
                    JOptionPane.showMessageDialog(this,"First Choose your Profile Picrure","Warning",JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    String cpro_pic = "src/profile pic/"+ffname+"."+fftype;
                    File ff1 = new File(pro_pic);
                    File ff2 = new File(cpro_pic);
                    iscopy = ff1.renameTo(ff2);
                    if(iscopy)
                    {
                        pro_pic_text.setText(cpro_pic);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this,"Error in Photo Upload..!","Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
    }
}