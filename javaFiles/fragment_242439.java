public static valueOf(name: string): Planet | null {
        const names = Object.keys(this);
        for (let i = 0; i < names.length; i++) {
            if (this[names[i]] instanceof Planet && name.toLowerCase() === names[i].toLowerCase()) {
                return this[names[i]];
            }
        }

        return null;
    }