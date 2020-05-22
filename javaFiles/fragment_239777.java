.method public static main([Ljava/lang/String;)V
    .registers 5

    .prologue
    array-length v1, p0

    const/4 v0, 0x0

    :goto_2
    if-ge v0, v1, :cond_e

    aget-object v2, p0, v0

    sget-object v3, Ljava/lang/System;->out:Ljava/io/PrintStream;

    invoke-virtual {v3, v2}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    :cond_e
    new-instance v0, Lcom/android/commands/locksettings/LockSettingsCmd;

    invoke-direct {v0}, Lcom/android/commands/locksettings/LockSettingsCmd;-><init>()V

    invoke-virtual {v0, p0}, Lcom/android/commands/locksettings/LockSettingsCmd;->run([Ljava/lang/String;)V

    const/4 v0, 0x0

    invoke-virtual {v0, p0}, Ljava/io/PrintStream;->println(Ljava/lang/Object;)V

    return-void
.end method