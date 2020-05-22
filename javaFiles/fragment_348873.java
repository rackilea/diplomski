@Bindable
class Address { 
    String street, number, city
    String toString() { "address[street=$street,number=$number,city=$city]" }
} 



def address = new Address(street: 'Evergreen Terrace', number: '742', city: 'Springfield')
   def BL = new BorderLayout()

def swing = new SwingBuilder()
def swingBuilder = new SwingBuilder()
swingBuilder.edt {  // edt method makes sure UI is build on Event Dispatch Thread.


    lookAndFeel 'nimbus'  // Simple change in look and feel.

    frame(title: 'Address', size: [1000, 800],
            show: true, locationRelativeTo: null,

            defaultCloseOperation: EXIT_ON_CLOSE) {

        borderLayout(vgap: 5)

        panel(constraints: BorderLayout.CENTER,
                border: compoundBorder([emptyBorder(10), titledBorder('Enter your address:')])) {
            tableLayout {

                tr {
                    td {
                        label 'Street:'  // text property is default, so it is implicit.
                    }
                    td {
                        textField address.street, id: 'streetField', columns: 20
                    }
                }
                tr {
                    td {
                        label 'Number:'
                    }
                    td {
                        textField id: 'numberField', columns: 5, text: address.number
                    }
                }
                tr {
                    td {
                        label 'City:'
                    }
                    td {
                        textField id: 'cityField', columns: 20, address.city
                    }
    td {
                        textField id: 'cityField', columns: 20, address.city
                    }
                }
            }


          scrollPane(id:'scroll',preferredSize: [200,200], constraints: context.CENTER) {



        panel(layout: new FlowLayout()) {


    imagelabelx=        label(icon: imageIcon(new URL('pokemon.png')))
        }


          }





          }







            panel(constraints: BorderLayout.SOUTH) {
                button text: 'Save', actionPerformed: {
                    println address
    imagelabelx.icon= imageIcon(new URL('pokemon2.png'))
                }
            }

            // Binding of textfield's to address object.
            bean address,
                street: bind { streetField.text },
                number: bind { numberField.text },
                city: bind { cityField.text }
        } 
    }