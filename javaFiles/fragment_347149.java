class IntArrayOracleType : UserType {
    override fun assemble(cached: Serializable?, owner: Any?) = deepCopy(cached)

    override fun deepCopy(value: Any?) = (anyToIntArraySafe(value))?.copyOf()

    override fun disassemble(value: Any?) = deepCopy(value)

    override fun equals(x: Any?, y: Any?) = (x?.equals(y) ?: y?.equals(x)) ?: true

    override fun hashCode(x: Any?) = x?.hashCode() ?: 0

    override fun isMutable() = true

    override fun nullSafeGet(resultSet: ResultSet,
                             names: Array<out String>?,
                             session: SharedSessionContractImplementor?,
                             owner: Any?): Any? {
        if (resultSet.wasNull() || names == null) {
            return null
        }

        return anyToIntArraySafe(resultSet.getArray(names[0])?.array) ?: intArrayOf()
    }

    override fun nullSafeSet(statement: PreparedStatement, value: Any?, index: Int, session: SharedSessionContractImplementor) {
        val connection = statement.connection
        if (value == null) {
            statement.setNull(index, Types.ARRAY, "INTEGER_VARRAY")
        } else {
            val oraConnection = connection.unwrap(OracleConnection::class.java)
            val array = oraConnection.createOracleArray("INTEGER_VARRAY", value)
            statement.setArray(index, array)
        }
    }

    override fun replace(original: Any?, target: Any?, owner: Any?) = (anyToIntArraySafe(original))?.copyOf()

    override fun returnedClass() = IntArray::class.java

    override fun sqlTypes() = intArrayOf(Types.ARRAY)
}

/**
 * Takes Any? and tries to cast it to Array and than to IntArray - BigDecimal is checked.
 *
 * Note that when given array contains anything else then BigDecimal or Int exception will be thrown
 * @return IntArray if successfully casted, null otherwise
 * */
internal fun anyToIntArraySafe(array: Any?) = (array as? IntArray) ?: (array as? Array<*>)?.map {
    it as? Int ?: (it as BigDecimal).intValueExact()
}?.toIntArray()