/**
 * @see java.lang.Object#equals(java.lang.Object)
 */
@Override
public boolean equals(Object obj) {

    if (obj instanceof IModePayementDao ) {

        if (((IModePayementDao ) obj).getId().equals(this.id)) {
            return true;
        }
        else {
            return false;
        }
    }
    else {
        return false;
    }

}