<c:forEach items="${map}" var="entry">
    <div>
        Map key: ${entry.key}<br>
        Tile name: ${entry.value.name}<br>
        Tile description: ${entry.value.description}<br>
        Tile image: <img src="${entry.value.imagepath}">
    </div>
</c:forEach>