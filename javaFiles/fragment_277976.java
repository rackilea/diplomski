<p>
        #{field 'tags'}
        <label>Enter some tags:</label>
        <input type="text" size="50" 
            name="${field.name}" value="${post?.tags?.join(' ')}" />
        #{/field}
    </p>