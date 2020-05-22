private void check(Object obj)
{
    if (obj == null || obj.getClass().isAnnotationPresent(Deprecated.class)
        || obj.getClass().isAnnotationPresent(SkipClass.class))
    {
        return;
    }

    Class< ? > cls = obj.getClass();
    nameStack.add(simpleName);
    traceStack.add(new TraceSlot(obj, fieldDescription));

    if (!(obj instanceof Serializable) && (!Proxy.isProxyClass(cls)))
    {
        throw new WicketNotSerializableException(toPrettyPrintedStack(obj.getClass().getName())
            .toString(), exception);
    }
    if (obj instanceof IdObject)
    {
        Serializable id = ((IdObject) obj).getIdAsSerializable();
        if (id != null && !(id instanceof Long && ((Long) id) <= 0))
        {
            throw new WicketContainsEntityException(toPrettyPrintedStack(
                obj.getClass().getName()).toString(), exception);
        }
    }
    if (obj instanceof LoadableDetachableModel)
    {
        LoadableDetachableModel< ? > ldm = (LoadableDetachableModel< ? >) obj;
        if (ldm.isAttached())
        {
            throw new WicketContainsAttachedLDMException(toPrettyPrintedStack(
                obj.getClass().getName()).toString(), exception);
        }
    }