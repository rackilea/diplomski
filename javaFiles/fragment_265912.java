private void genComponents(final Pet pet) {

    ....

    feedBtn.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            pet.feedPet();   <-- pet refers to the parameter, but it is out of scope when this gets executed.
        }
    });

    ....
}