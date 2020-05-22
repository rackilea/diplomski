// field value type
if ( !m_isMultiple )
{
    // value type must not be specified for unary references
    if ( m_field_collection_type != null )
    {
        throw componentMetadata.validationFailure( "Field value type must not be set for unary field references." );
    }
}