for (int out = 0; out < f.length; out++) {
        for (int in = 0; in < f[out].length; in++) {
            if (f.length != f[out].length || f[out][in] != f[in][out])) {
                return false;
            }
        }
    }
    return true;