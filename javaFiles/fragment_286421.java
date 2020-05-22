public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 80; i++) {
                    jp.setPreferredSize(new Dimension(200,(i+70)));
                    **jp.revalidate();**
                }
                //System.out.println(jp.getHeight());
            }