...
if (field.isLocal()) {
            LocalMember local = (LocalMember)field;
            if (local.scopeNumber < ctx.frameNumber && !local.isFinal()) {
                env.error(where, "invalid.uplevel", id);
            }
            if (!vset.testVar(local.number)) {
                env.error(where, "var.not.initialized", id);
                vset.addVar(local.number);
            }
            local.readcount++;
        }
...