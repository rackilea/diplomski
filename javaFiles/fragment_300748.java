else if (status.isNewTransaction()) { //requiresnew
    doRollback(status);
}
else if (status.hasTransaction()) { //requiered
        [...]
        doSetRollbackOnly(status);
    }
}