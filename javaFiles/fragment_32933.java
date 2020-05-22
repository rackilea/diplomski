@flash.entrySet.iterator.map { key =>
    <div class="row">
        <div class="large-12 columns">
            <div class="alert-box radius @{key.getKey}" data-alert="">
                @{key.getKey.toUpperCase} &mdash; @{key.getValue}
                <a href="#" class="close">&times;</a>
            </div>
        </div>
    </div>
}