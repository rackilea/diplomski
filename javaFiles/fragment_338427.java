public class ACE {
    private final Set<Right> accessrights = EnumSet.noneOf(Right.class);
    private final Set<Inheritance> inherit_flags
            = EnumSet.noneOf(Inheritance.class);

    public static enum Right {
        traverse, list, dir_read_attr, dir_read_ext_attr, add_file, add_subdir,
        dir_write_attr, dir_write_ext_attr, delete_child, std_delete,
        std_read_dac, std_write_dac, std_write_owner,
        dir_gen_all, dir_gen_execute, dir_gen_read, dir_gen_write, modify;
    }

    public static enum Inheritance {
        object_inherit, container_inherit, no_prop_inherit, inherit_only,
        inherited_ace;
    }

    public Set<Right> getAccessrights() {
        return accessrights;
    }

    public Set<Inheritance> getInherit_flags() {
        return inherit_flags;
    }

}