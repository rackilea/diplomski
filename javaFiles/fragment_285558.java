public boolean ope(boolean...list)
{
    for (boolean value: list) {
        if (!value) {
            return false;
        }
    }

    return true;
}