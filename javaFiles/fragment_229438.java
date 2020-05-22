now = current_fs_time(inode->i_sb);

    //attr->ia_ctime = now;  (1) Comment this out
    if (!(ia_valid & ATTR_ATIME_SET))
        attr->ia_atime = now;
    if (!(ia_valid & ATTR_MTIME_SET)) {
        attr->ia_mtime = now;
    }
    else { //mtime is modified to a specific time. (2) Add these lines
        attr->ia_ctime = attr->ia_mtime; //Sets the ctime
        attr->ia_atime = attr->ia_mtime; //Sets the atime (optional)
    }