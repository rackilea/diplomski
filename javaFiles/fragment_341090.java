public TypedQuery<X> setParameter(String name, Object value) {
    try {
      if(value instanceof Collection) {
        this.query.setParameterList(name, (Collection)value);
      } else {
        this.query.setParameter(name, value);
      }

      this.registerParameterBinding(this.getParameter(name), value);
      return this;
    } catch (QueryParameterException var4) {
      throw new IllegalArgumentException(var4);
    } catch (HibernateException var5) {
      throw this.getEntityManager().convert(var5);
    }
  }